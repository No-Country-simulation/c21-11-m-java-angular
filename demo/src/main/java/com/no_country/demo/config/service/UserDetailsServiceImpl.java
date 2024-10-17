package com.no_country.demo.config.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.no_country.demo.config.util.JwtUtils;
import com.no_country.demo.dto.auth.LoginRequest;
import com.no_country.demo.dto.auth.StudentRegisterRequest;
import com.no_country.demo.dto.auth.TeacherRegisterRequest;
import com.no_country.demo.dto.auth.response.AuthResponse;
import com.no_country.demo.entities.Email;
import com.no_country.demo.entities.Student;
import com.no_country.demo.entities.Teacher;
import com.no_country.demo.entities.UserEntity;
import com.no_country.demo.entities.enums.Rol;
import com.no_country.demo.repository.EmailRepositorylog;
import com.no_country.demo.repository.StudentRepository;
import com.no_country.demo.repository.TeacherRepositorylog;
import com.no_country.demo.repository.UserRepositorylog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserRepositorylog userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepositorylog teacherRepository;

    @Autowired
    private EmailRepositorylog emailRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + email + " no existe"));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userEntity.getRol().name())); // Asignar el rol como autoridad

        return new org.springframework.security.core.userdetails.User(
                userEntity.getEmail().getEmail(),
                userEntity.getPassword(),
                userEntity.isEnable(),
                userEntity.isAccountNoExpired(),
                !userEntity.isCredentialNoExpired(),
                !userEntity.isAccounLocked(),
                authorities
        );
    }

    public AuthResponse loginUser(LoginRequest login) {
        String email = login.getEmail();
        String password = login.getPassword();

        Authentication authentication = authenticate(email, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);
        return new AuthResponse(email, "Usuario logeado con éxito!", accessToken, true);
    }

    private Authentication authenticate(String username, String password) {
        UserDetails userDetails = loadUserByUsername(username);

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("La contraseña es incorrecta");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    public AuthResponse registerStudent(StudentRegisterRequest request) {
        // Crear la instancia de Email
        Email email = new Email();
        email.setEmail(request.getEmail());

        // Guardar el Email en la base de datos
        email = emailRepository.save(email);

        Student student = Student.builder()
                .name(request.getName())
                .lastname(request.getLastname())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(email) //Hace falta que sea bidireccional?
                .locality(request.getLocality())
                .dni(request.getDni())
                .address(request.getAddress())
                .birthdate(request.getBirthdate())
                .phone(request.getPhone())
//                .dateRegistrationCourse(request.getDateRegistrationCourse())
//                .currentCourse(request.getCurrentCourse())
//                .tutor(request.getTutor())
                .rol(Rol.STUDENT)  // Asignar el rol de estudiante
                .isEnable(true)
                .accounLocked(false)
                .accountNoExpired(true)
                .credentialNoExpired(true)
                .build();

        studentRepository.save(student);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + student.getRol())); // Asignar el rol como autoridad

        Authentication authentication = new UsernamePasswordAuthenticationToken(student.getEmail().getEmail(), student.getPassword(), authorities);
        String accessToken = jwtUtils.createToken(authentication);

        return new AuthResponse(student.getEmail().getEmail(), "Usuario creado", accessToken, true);
    }

    public AuthResponse registerTeacher (TeacherRegisterRequest request) {

        // Crear la instancia de Email
        Email email = new Email();
        email.setEmail(request.getEmail());

        // Guardar el Email en la base de datos
        email = emailRepository.save(email);

        Teacher teacher = Teacher.builder()
                .name(request.getName())
                .lastname(request.getLastname())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(email)
                .locality(request.getLocality())
                .dni(request.getDni())
                .address(request.getAddress())
                .birthdate(request.getBirthdate())
                .phone(request.getPhone())
//                .file(request.getFile())
                .rol(Rol.TEACHER)  // Asignar el rol de profesor
                .isEnable(true)
                .accounLocked(false)
                .accountNoExpired(true)
                .credentialNoExpired(true)
                .build();


        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + teacher.getRol())); // Asignar el rol como autoridad

        Authentication authentication = new UsernamePasswordAuthenticationToken(teacher.getEmail().getEmail(), teacher.getPassword(), authorities);
        String accessToken = jwtUtils.createToken(authentication);

        return new AuthResponse(teacher.getEmail().getEmail(), "Usuario creado", accessToken, true);
    }

}
