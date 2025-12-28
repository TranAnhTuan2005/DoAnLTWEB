package vn.edu.nlu.fit.model;

public class PaymentMethods {
    private int id;
    private String methodName;
    private int isActived;

    public PaymentMethods() {
    }

    public PaymentMethods(int id, String methodName, int isActived) {
        this.id = id;
        this.methodName = methodName;
        this.isActived = isActived;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public int getIsActived() {
        return isActived;
    }

    public void setIsActived(int isActived) {
        this.isActived = isActived;
    }

    @Override
    public String toString() {
        return "PaymentMethods{" +
                "id=" + id +
                ", methodName='" + methodName + '\'' +
                ", isActived=" + isActived +
                '}';
    }
}