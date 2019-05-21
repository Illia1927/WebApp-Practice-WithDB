package mate.academy.webApp.model;

public class Code {
    private Long codeId;
    private Long userId;
    private Long goodId;
    private String value;

    public Code(Long codeId, Long userId, Long goodId, String value) {
        this.codeId = codeId;
        this.userId = userId;
        this.goodId = goodId;
        this.value = value;
    }

    public Code(Long userId, Long goodId, String value) {
        this.userId = userId;
        this.goodId = goodId;
        this.value = value;
    }

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Code)) return false;

        Code code = (Code) o;

        if (getCodeId() != null ? !getCodeId().equals(code.getCodeId()) : code.getCodeId() != null) return false;
        if (getGoodId() != null ? !getGoodId().equals(code.getGoodId()) : code.getGoodId() != null) return false;
        if (getUserId() != null ? !getUserId().equals(code.getUserId()) : code.getUserId() != null) return false;
        return getValue() != null ? getValue().equals(code.getValue()) : code.getValue() == null;

    }

    @Override
    public int hashCode() {
        int result = getCodeId() != null ? getCodeId().hashCode() : 0;
        result = 31 * result + (getGoodId() != null ? getGoodId().hashCode() : 0);
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Code{" +
                "codeId=" + codeId +
                ", goodId=" + goodId +
                ", userId=" + userId +
                ", value='" + value + '\'' +
                '}';
    }
}
