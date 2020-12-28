package com.hamal.lab6.domain;

import javax.persistence.*;

@Entity //@Entity — вказує, що даний клас є збереженою сутністю.


//@Table  С помощью этой аннотации мы говорим Hibernate,
// с какой именно таблицей необходимо связать (map) данный класс.
@Table(name = "airline")
public class Airline{


    /*
Анотація @Basic – вказує, що дане поле буде зберігатися в базу даних.
Зазвичай дану анотацію не вказують, крім тих випадків, коли необхідно вказати
додаткові параметри відображення. Fetch дозволяє вказати стратегію отримання
даних (EAGER – дані вибираються одразу в запиті (за замовчуванням), LAZY –
дані вибираються при першому зверненні до них). Властивість optional
дозволяє вказати, чи дозволені null значення в колонці таблички і в полі
відповідно. За замовчуванням optional=true, що значить, що null значення
дозволені.
@Basic
private String fio;
@Basic(fetch=LAZY, optional = false)
private String name;



Анотації Java для роботи з БД:

https://javastudy.ru/spring-data-jpa/annotation-persistence/
 */

    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;



// С помощью аннотации @Id мы указываем первичный ключ (Primary Key) данного класса.


//Аннотация @Column определяет к какому столбцу в таблице БД относится конкретное поле класса (аттрибут класса).
//Наиболее часто используемые аттрибуты аннотации @Column такие:
//- name (Указывает имя столбца в таблице)
//- unique (Определяет, должно ли быть данноезначение уникальным)
//- nullable (Определяет, может ли данное поле быть NULL, или нет.)
//- length (Указывает, какой размер столбца (например колчиство символов, при использовании String))


//          Getters and Setters

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /*
    https://www.laliluna.de/jpa-hibernate-guide/ch06s06.html

    The equals method

The equals method is implemented by java.lang.Object and, if not overridden, will behave as ==.
The intention of equals is to compare objects from a business point of view.
For example a class Country has a field isocode like DE for Germany or FR for France etc.
We could consider to compare two countries using the isocode.


Hibernate and equals

 Do I have to implement equals and hashCode?
Answer: It depends.
A composite id must implement both methods or the id will not work properly.
Hibernate must be able to compare ids.
A composite id will most likely use all its id fields in the equals and hashCode methods.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airline airline = (Airline) o;

        if (id != null ? !id.equals(airline.id) : airline.id != null) return false;
        if (name != null ? !name.equals(airline.name) : airline.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}