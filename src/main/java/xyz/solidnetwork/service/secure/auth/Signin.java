package xyz.solidnetwork.service.secure.auth;

public class Signin {
    private String token;

    public Signin() {

        token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwczovL2Jhbmsuc29saWRuZXR3b3JrLnh5eiIsImlhdCI6MTUxNjIzOTAyMiwidXNlciI6eyJhdXRoIjoiMDE4ZTQ4NDQtZThkOC03MjQwLTg1YTMtMzRiODc4M2E2NmNjIiwiaWQiOiJQYXNzLWEtR3JpbGxlIiwiZmlyc3ROYW1lIjoiSm9obiIsImxhc3ROYW1lIjoiRG9lIn19.RxahR1FB-I7TRzKCuNzCkkCUKxrbx8ADDtPMHtF74ac";

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
