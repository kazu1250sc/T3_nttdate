package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Profile;

/**
 * ユーザー情報 Repository
 */
@Repository
public interface ListProfileEditRepository extends JpaRepository<Profile, Long> {
	
	/*@Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> findOne(int id) {

        // SELECT文
        String query = "SELECT "
                + " employee_id,"
                + " employee_name,"
                + " age "
                + "FROM employee "
                + "WHERE employee_id=?";

        // 検索実行、mapで取得した値をemployeeクラスのインスタンスにセット
        Map<String, Object> employee = jdbcTemplate.queryForMap(query, id);

        return employee;
    }*/
}