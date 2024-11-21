module org.axel {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j;
    requires java.persistence;
    requires java.naming;

    opens org.axel to javafx.fxml;
    exports org.axel;
}
