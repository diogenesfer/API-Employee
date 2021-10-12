package uniso.br.employeeapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FuncionarioService {

    @GET("funcionarios/{id}")
    Call<Funcionario>buscarFuncionarioPorId(@Path("id") String id);
}
