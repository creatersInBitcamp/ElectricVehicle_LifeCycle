package com.bitcamp.team_project_eco.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository {

    Optional<User> findByUserId(String userId);

    Optional<User> findByEmail(String email);

    @Query(value = "SELECT sex, count(*) as count FROM user GROUP BY sex", nativeQuery = true)
    List<Map<String, Object>> counting();

    @Query(value = "select floor((year(now())-year(birth_date))/10)*10 age, count(birth_date) as cnt from user where birth_date!='' group by age", nativeQuery = true)
    List<Map<String, String>> countAge();

    @Query(value = "select car_name, price from electric_car where eccar_id = :eccarId", nativeQuery = true)
    List<Map<String, String>> findCarNamePrice(@Param("eccarId") String eccarId);

    @Query(value = "select brand, count(*) as count from electric_car group by brand",nativeQuery = true)
    List<Map<String, String>> findBrandCar();

    // Select electric_car.brand, count(*) from used_car inner Join electric_car on used_car.eCCAR_ID = electric_car.eCCAR_ID group by  electric_car.brand
    // Select electric_car.brand, count(*) from used_car, electric_car where used_car.eCCAR_ID = electric_car.eCCAR_ID group by  electric_car.brand ;
    @Query(value = "Select electric_car.brand, count(*) as count from used_car inner Join electric_car on used_car.eccar_id = electric_car.eccar_id group by  electric_car.brand",nativeQuery = true)
    List<Map<String, String>> findBrandUsedCar();

    @Query(value = "update User u set u.profileImage = :profileImage, u.email = :email, u.phoneNumber = :phoneNumber, u.addr = :addr, u.profileText = :profileText where u.userSeq = :userSeq")
    void updateUser(@Param("userSeq") Long userSeq, @Param("profileImage") String profileImage, @Param("profileText") String profileText, @Param("email") String email, @Param("phoneNumber") String phoneNumber, @Param("addr") String addr);

    @Query(value = "update user set password = :password where user.user_id = :userId",nativeQuery = true)
    void changePassword(@Param("userId") String userId, @Param("password") String password);
}
