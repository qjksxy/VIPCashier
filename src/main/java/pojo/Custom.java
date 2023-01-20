package pojo;

public class Custom {
    // 顾客预留电话
    String phone;
    // 顾客预留姓名
    String name;

    // 顾客初始充值金额
    int amount;
    // 顾客账户余额，以分为单位
    int balance;
    // 顾客账户优惠级别
    String level;

    // 备注
    String remark;

    public Custom() {
    }

    public Custom(String phone, String name, int amount, int balance, String level, String remark) {
        this.phone = phone;
        this.name = name;
        this.amount = amount;
        this.balance = balance;
        this.level = level;
        this.remark = remark;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

        Custom custom = (Custom) o;

        return phone != null ? phone.equals(custom.phone) : custom.phone == null;
    }

    @Override
    public int hashCode() {
        return phone != null ? phone.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Custom{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                ", level='" + level + '\'' +
                ", remarks='" + remark + '\'' +
                '}';
    }
}
