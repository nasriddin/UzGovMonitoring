package uz.safar.open_data.controller;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uz.safar.open_data.model.Rate;
import uz.safar.open_data.payload.RateChar;

import javax.servlet.http.HttpServletRequest;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Controller
public class OpenDataController {


    @Autowired
    HikariDataSource hds;
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs=null;
    ResultSet rs = null;

//    @GetMapping("/")
//    public String loginPage(){
//        return "index";
//    }


    @GetMapping("/")
    public String list(Model model){
        ArrayList<RateChar> users = new ArrayList<>();
        try {
            conn = hds.getConnection();
            ps = conn.prepareStatement("select rt.employee_id,(select count(r.status) from Rate r where r.status >2 and r.employee_id=rt.employee_id) from Rate rt");
            ps.execute();
            rs = ps.getResultSet();
            while(rs.next()){
                RateChar user = new RateChar();
                user.setEmployee(rs.getLong(1));
                user.setRate_count(rs.getLong(2));
                users.add(user);
            }

            model.addAttribute("users", users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}
