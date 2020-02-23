package com.wolfe.stations.models;

import java.util.Objects;
import java.util.UUID;

public class Login {
    private UUID uuid;
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;

    public UUID getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getMd5() {
        return md5;
    }

    public String getSha1() {
        return sha1;
    }

    public String getSha256() {
        return sha256;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return Objects.equals(uuid, login.uuid) &&
                Objects.equals(username, login.username) &&
                Objects.equals(password, login.password) &&
                Objects.equals(salt, login.salt) &&
                Objects.equals(md5, login.md5) &&
                Objects.equals(sha1, login.sha1) &&
                Objects.equals(sha256, login.sha256);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, username, password, salt, md5, sha1, sha256);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Login{");
        sb.append("uuid=").append(uuid);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", salt='").append(salt).append('\'');
        sb.append(", md5='").append(md5).append('\'');
        sb.append(", sha1='").append(sha1).append('\'');
        sb.append(", sha256='").append(sha256).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
