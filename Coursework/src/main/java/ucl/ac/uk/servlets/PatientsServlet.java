package ucl.ac.uk.servlets;

import ucl.ac.uk.model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patients")
public class PatientsServlet extends HttpServlet {
    private Model model;

    @Override
    public void init() throws ServletException {
        // Initialize the model with the CSV file path
        // Adjust the path as needed for your setup
        String dataFilePath = this.getServletContext().getRealPath("WEB-INF/data/patients100.csv");
        model = new Model(dataFilePath);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("patientsList", model.getAllPatients());
        req.getRequestDispatcher("/WEB-INF/views/patients.jsp").forward(req, resp);
    }
}
