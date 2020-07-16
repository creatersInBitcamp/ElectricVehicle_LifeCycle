package com.bitcamp.team_project_eco.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

@Component("pxy") @Lazy
public class Proxy {
    public String string(Object o){
        Function<Object, String> f = String::valueOf;
        return f.apply(o);
    }
    public Integer integer(String s) {
        Function<String, Integer> i = Integer::parseInt;
        return i.apply(s);
    }
    public Boolean equals(String t, String u) {
        BiPredicate<String, String> e = String::equals;
        return e.test(t, u);
    }
    public void print(String t){
        Consumer<String> c = System.out::print;
        c.accept(t);
    }
    public void println(String t){
        Consumer<String> c = System.out::println;
        c.accept(t);
    }
}
