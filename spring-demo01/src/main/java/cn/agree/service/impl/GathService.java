package cn.agree.service.impl;

import java.util.*;

public class GathService {

    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String, String> myMap;
    private Properties myProps;

    public String[] getMyStrs() {
        return myStrs;
    }

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public List<String> getMyList() {
        return myList;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public Set<String> getMySet() {
        return mySet;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public Properties getMyProps() {
        return myProps;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    @Override
    public String toString() {
        return "GathService{" +
                "myStrs=" + Arrays.toString(myStrs) +
                ", myList=" + myList +
                ", mySet=" + mySet +
                ", myMap=" + myMap +
                ", myProps=" + myProps +
                '}';
    }
}
