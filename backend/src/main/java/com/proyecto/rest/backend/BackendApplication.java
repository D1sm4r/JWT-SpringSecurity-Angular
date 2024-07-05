package com.proyecto.rest.backend;

import com.proyecto.rest.backend.entity.*;
import com.proyecto.rest.backend.repository.CargoRepository;
import com.proyecto.rest.backend.repository.NotificacionRepository;
import com.proyecto.rest.backend.repository.ProyectoRepository;
import com.proyecto.rest.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository,
						   CargoRepository cargoRepository,
						   NotificacionRepository notificacionRepository,
						   ProyectoRepository proyectoRepository) {
		return args -> {
			userRepository.deleteAll();
			cargoRepository.deleteAll();
			notificacionRepository.deleteAll();
			proyectoRepository.deleteAll();

			// Create Proyecto
			Proyecto proyecto1 = Proyecto.builder()
					.name("Proyecto serio")
					.build();

			Proyecto proyecto2 = Proyecto.builder()
					.name("Proyecto serio muy serio")
					.build();
			proyectoRepository.saveAll(List.of(proyecto1, proyecto2));

			// Crear cargos
			Cargo cargo1 = Cargo.builder()
					.name("Gerente")
					.saldo(12000)
					.build();

			Cargo cargo2 = Cargo.builder()
					.name("Ingeniero")
					.saldo(5000)
					.build();

			cargoRepository.saveAll(List.of(cargo1, cargo2));

			//Create permission
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();

			//create role
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission)) // le asignamos los permisos a los roles
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.EMPLEADO)
					.permissionList(Set.of(createPermission, readPermission)) // le asignamos los permisos a los roles
					.build();

			RoleEntity roleInvted = RoleEntity.builder()
					.roleEnum(RoleEnum.SUPERVISOR)
					.permissionList(Set.of(readPermission)) // le asignamos los permisos a los roles
					.build();

			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission)) // le asignamos los permisos a los roles
					.build();

			//create Users

			UserEntity userJavier = UserEntity.builder()
					.username("javier")
					.password("$2a$10$QtWqYmyxZJYZMr5knDHNoePUqPZ42z6ChipQyhTa4/hF5/FRrqDQG")
					.isEnabled(true)
					.accountNonExpired(true)//la cuenta esta activa osea no esta expirada
					.accountNonLocked(true)//la cuanta no esta bloqueada
					.credentialsNonExpired(true)//las credenciales no esta expirada
					.roles(Set.of(roleAdmin))
					.cargo(cargo1)
					.build();

			UserEntity userDismar = UserEntity.builder()
					.username("dismar")
					.password("$2a$10$QtWqYmyxZJYZMr5knDHNoePUqPZ42z6ChipQyhTa4/hF5/FRrqDQG")
					.isEnabled(true)
					.accountNonExpired(true)//la cuenta esta activa osea no esta expirada
					.accountNonLocked(true)//la cuanta no esta bloqueada
					.credentialsNonExpired(true)//las credenciales no esta expirada
					.roles(Set.of(roleUser))
					.cargo(cargo1)
					.build();

			UserEntity userMati = UserEntity.builder()
					.username("mati")
					.password("$2a$10$QtWqYmyxZJYZMr5knDHNoePUqPZ42z6ChipQyhTa4/hF5/FRrqDQG")
					.isEnabled(true)
					.accountNonExpired(true)//la cuenta esta activa osea no esta expirada
					.accountNonLocked(true)//la cuanta no esta bloqueada
					.credentialsNonExpired(true)//las credenciales no esta expirada
					.roles(Set.of(roleInvted))
					.cargo(cargo1)
					.build();

			UserEntity userDamian = UserEntity.builder()
					.username("damian")
					.password("$2a$10$QtWqYmyxZJYZMr5knDHNoePUqPZ42z6ChipQyhTa4/hF5/FRrqDQG")
					.isEnabled(true)
					.accountNonExpired(true)//la cuenta esta activa osea no esta expirada
					.accountNonLocked(true)//la cuanta no esta bloqueada
					.credentialsNonExpired(true)//las credenciales no esta expirada
					.roles(Set.of(roleDeveloper))
					.cargo(cargo1)
					.build();

			userRepository.saveAll(List.of(userJavier, userDismar, userMati, userDamian));

			Notificacion notificaion1 = Notificacion.builder()
					.mensaje("Hola Hola Hola")
					.user(userJavier)
					.build();

			Notificacion notificaion2 = Notificacion.builder()
					.mensaje("Hola Hola")
					.user(userDamian)
					.build();

			Notificacion notificaion3 = Notificacion.builder()
					.mensaje("Hola")
					.user(userDamian)
					.build();

			notificacionRepository.saveAll(List.of(notificaion1, notificaion2, notificaion3));
		};
	}

}
