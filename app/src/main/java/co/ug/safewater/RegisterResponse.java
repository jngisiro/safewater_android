package co.ug.safewater;

public class RegisterResponse {
    private String status;
    private Data1 data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data1 getData() {
        return data;
    }

    public void setData(Data1 data) {
        this.data = data;
    }
}

class Data1{
    private String message;
}