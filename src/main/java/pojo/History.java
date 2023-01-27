package pojo;

public class History {
    int id;
    String phone;
    String subject;
    String name;
    int money;
    long time;
    String remark;

    public History() {
    }

    public History(int id, String phone, String subject, String name, int money, long time, String remark) {
        this.id = id;
        this.phone = phone;
        this.subject = subject;
        this.name = name;
        this.money = money;
        this.time = time;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        History history = (History) o;

        return id == history.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", time=" + time +
                ", remark='" + remark + '\'' +
                '}';
    }
}
