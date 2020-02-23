package com.wolfe.stations.models;

import java.util.Objects;

public class Info {
    private String seed;
    private Integer results;
    private Integer page;
    private String version;

    public String getSeed() {
        return seed;
    }

    public Integer getResults() {
        return results;
    }

    public Integer getPage() {
        return page;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return Objects.equals(seed, info.seed) &&
                Objects.equals(results, info.results) &&
                Objects.equals(page, info.page) &&
                Objects.equals(version, info.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seed, results, page, version);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Info{");
        sb.append("seed='").append(seed).append('\'');
        sb.append(", results=").append(results);
        sb.append(", page=").append(page);
        sb.append(", version='").append(version).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
