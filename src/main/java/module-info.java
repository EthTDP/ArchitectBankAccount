module edu.sdccd.cisc191.architectbankaccount {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.aop;
    requires spring.core;
    requires spring.beans;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires spring.data.jpa;
    requires spring.data.commons;

    opens edu.sdccd.cisc191.architectbankaccount.database;

    opens edu.sdccd.cisc191.architectbankaccount;
    exports edu.sdccd.cisc191.architectbankaccount;
}