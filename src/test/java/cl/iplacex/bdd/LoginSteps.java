package cl.iplacex.bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {
    private String usuario;
    private String password;
    private String resultado;

    @Given("que existe un usuario registrado")
    public void usuarioRegistrado() {
        usuario = "admin";
    }

    @When("ingresa usuario {string} y contraseña {string}")
    public void ingresarCredenciales(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    @When("selecciona iniciar sesión")
    public void seleccionarLogin() {
        if ("admin".equals(usuario) && "123456".equals(password)) {
            resultado = "acceso";
        } else {
            resultado = "rechazo";
        }
    }

    @Then("el resultado esperado es {string}")
    public void verificarResultado(String esperado) {
        assertEquals(esperado, resultado);
    }
}
