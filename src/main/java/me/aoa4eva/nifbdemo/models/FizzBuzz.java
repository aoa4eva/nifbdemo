package me.aoa4eva.nifbdemo.models;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;

@Entity
public class FizzBuzz {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private long id;

    @NotEmpty
    private String userName;

    @Range
    @Min(value=10)
    @Max(value=1000)
    private int number;

    public String getUserName() {
        return userName;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public ArrayList<String> runFizzBuzz()
    {
        ArrayList fBO = new ArrayList();

        String fizzBuzzString="";
        for(int i=1; i<=this.getNumber(); i++)
        {
            if(i%2==0)
                fizzBuzzString+="Copy";
            if(i%3==0)
                fizzBuzzString+="Fizz";
            if(i%5==0)
                fizzBuzzString+="Buzz";
            if(i%10==0)
                fizzBuzzString+="Cat";
            if(i%2!=0&&i%3!=0&&i%5!=0&&i%10!=0)
                fizzBuzzString=""+i;

           fBO.add(fizzBuzzString);
           fizzBuzzString="";
        }

        return fBO;


    }



}
