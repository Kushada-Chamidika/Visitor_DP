package designpatterns02day11visitorpattern;

/**
 *
 * @author 1999k
 */
public class Test {

    public static void main(String[] args) {

        A a = new A(10);
        B b = new B(20);

        Visitor visitor = new SubVisitor2();

//        System.out.println(a.m(visitor));
//        System.out.println(b.n(visitor));
        System.out.println(a.accept(visitor));
        System.out.println(b.accept(visitor));
    }

}

abstract class Element {

    public abstract int accept(Visitor visitor);

}

class A extends Element {

    int x;

    public A(int x) {
        this.x = x;
    }

    //me method eka thama passe wenas karanna one wenne 
//    public int m() {     // visitor pattern eke anuwa api me method me class eke thiyanne na e kiyanne apita one wade method eka wenas karanna nisa eka api vivistor class ekata thama denne ethakota  e class eka interface eke implement karana nisa method deka overide karala adala parameter dala eyege  margen variable access karala eyata one deyak e method eka thula karanan puluwan ethakota mainly me pattern eke wenan one wade wela  e kiyanne class ekata change ekk nokara eyata one weleka method eka wenas karanan puluwan
//        return x + 10;
//    }
//    public int m(Visitor visitor) {  // api pahala use karana method eka meya gawath thinan one ne naththam eka meyage ekk wenen nane dn meke karanne kalin wage neme vivistor thama wena wade kaiyanne meya karal thinne vivistor ge api hapau method eka call karnawa ekata parameter widiyata me class type ewa one nisa this kiyane ke currently run wena object eka pass karala thinawa
//        return visitor.visit(this);
//    }
    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

class B extends Element {

    int y;

    public B(int y) {
        this.y = y;
    }

    // me metod eka thama passe wenas karanna one wenne 
//    public int n() {  // methods meya gawa na visitor gawa thinne meyage data aran thama method eke wenna one wade wenne
//        return y * 2;
//    }
//    public int n(Visitor visitor) {  // me karal thna widiyata apita me method eke mona wenask karnana one unath meke wenask karanna one wenne na apita kamathi wiidyata pahalin wenas karanna puluwan
//        return visitor.visit(this);
//    }
    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

}

interface Visitor {

    // class ekata wenask nokara change karanna one kiyana eka thama me pattern eke key point eka e nisa meekdi 
    // api karanne wenama interface ekk hadanwa vivistor kiyala passe eken karanne ara api uda hadapu wenas wenna
    // one methd deka wenauwata visit kiyala nama dapu abstract 
    // method dekk hadnawa habai wenasa thama eka method ekk paramether widiyata ganne A kenek anika B kenek ,
    // e kiyanne api hadaganna method wala parameter wenna one api wenas karanna yana method thina class wala type
    public abstract int visit(A a); // A ge visit method eka

    public abstract int visit(B b); // B ge visit method eka

    // method deke nama wenas wenan puluwan namuth dekatama ekama nama thinna one parameter eka witharai wenas wenne
}

class SubVisitor1 implements Visitor {

    @Override
    public int visit(A a) {
        return a.x + 10;  // me widiyata eyata one weleka one widiyata eyage wade method eka athule hadaganna puluwan 
    }

    @Override
    public int visit(B b) {
        return b.y * 2;
    }
}

// me widiyata kalin code ain nokara ewath thiyan me widiyata aluthe hadana hadan unath yanan puluwan call karaddi class eka wenas karanm wade hari
class SubVisitor2 implements Visitor {

    @Override
    public int visit(A a) {
        return a.x + 3;  // me widiyata eyata one weleka one widiyata eyage wade method eka athule hadaganna puluwan 
    }

    @Override
    public int visit(B b) {
        return b.y / 5;
    }
}
