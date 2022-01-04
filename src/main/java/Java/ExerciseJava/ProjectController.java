/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.ExerciseJava;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lenovo
 */
@Controller
public class ProjectController {
    @RequestMapping("/tampil")
    public String inputData(HttpServletRequest data, Model discount)
    {
        String namaSayur = data.getParameter("nama");
        String hargaSayur = data.getParameter("harga");
        String jumlahSayur = data.getParameter("jumlah");
        String jumlahUang = data.getParameter("uang");
        String diskon = "";
        
        
        Double jUang = Double.valueOf(jumlahUang);
        Double pHarga=Double.valueOf(hargaSayur);
        Double qJumlah = Double.valueOf(jumlahSayur);
        Double totalHarga = pHarga*qJumlah;
        Double gettotal = null;
        Double hargaDiskon = null;
        
        if(totalHarga < 16000){
            gettotal = totalHarga-(0*totalHarga/100);
            diskon="0%";
            hargaDiskon = (0*totalHarga/100);
        }
        else if(totalHarga>=16000 && totalHarga<25000){
            gettotal = totalHarga-(10*totalHarga/100);
            diskon="10%";
            hargaDiskon = (10*totalHarga/100);
        }
        else if (totalHarga>=25000){
            gettotal=totalHarga-(15*totalHarga/100);
            diskon="15%";
            hargaDiskon = (15*totalHarga/100);
        }
        
        Double kembalian = jUang - gettotal;
        
        
        discount.addAttribute("name",namaSayur);
        discount.addAttribute("price",hargaSayur);
        discount.addAttribute("quantity",jumlahSayur);
        discount.addAttribute("TotalPrice",gettotal);
        discount.addAttribute("priceTotal",totalHarga);
        discount.addAttribute("discPrice",hargaDiskon);
        discount.addAttribute("disc",diskon);
        discount.addAttribute("money",jumlahUang);
        discount.addAttribute("return",kembalian);
        
        return "viewPage";
    }
}
