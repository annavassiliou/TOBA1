/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Annie
 */
@WebServlet(name = "ReportsServlet", urlPatterns = {"/ReportsServlet"})
public class ReportsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        // create the workbook, its worksheet, and its title row
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("User Report");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Users Joined");

        // create the header row
        row = sheet.createRow(2);
        row.createCell(0).setCellValue("UserID");
        row.createCell(1).setCellValue("FirstName");
        row.createCell(2).setCellValue("LastName");
        row.createCell(3).setCellValue("UserName");

        try {
            // read database rows
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM user";
            ResultSet rset = statement.executeQuery(query);

            // create the spreadsheet rows
            int i = 3;
            while (rset.next()) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(rset.getInt("UserID"));
                row.createCell(1).setCellValue(rset.getInt("FirstName"));
                row.createCell(2).setCellValue(rset.getInt("LastName"));
                row.createCell(3).setCellValue(rset.getInt("UserName"));
            }
            rset.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.log(e.toString());
        }

// set the response headers
        response.setHeader("content-disposition",
                "attachment; filename=userReport.xls");
        response.setHeader("cache-control", "no-cache");

        OutputStream out = response.getOutputStream();
        workbook.write(out);
        out.close();
    }

}