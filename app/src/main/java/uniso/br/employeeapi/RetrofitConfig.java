package uniso.br.employeeapi;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit;

    public RetrofitConfig(){
        retrofit =
                new Retrofit.Builder()
                        .baseUrl("https://615ce770c29813001773635e.mockapi.io/uniso/")
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
    }

    public FuncionarioService getUserService(){
        return this.retrofit.create(FuncionarioService.class);
    }


}
