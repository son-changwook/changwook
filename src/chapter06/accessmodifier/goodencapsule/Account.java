package chapter06.accessmodifier.goodencapsule;

import chapter06.accessmodifier.Membership;

import java.time.LocalDate;

import static chapter06.accessmodifier.Membership.REGULAR;
import static java.time.LocalDate.now;

public class Account {
    private final Membership membership;
    private final LocalDate expDate;
    private final LocalDate serviceDate;

    public Account ( Membership membership, LocalDate expDate, LocalDate serviceDate ) {
        this.membership = membership;
        this.expDate = expDate;
        this.serviceDate = serviceDate;
    }

    public boolean hasGradePermission(Membership membership){
        //return acc.getMembership() == REGULAR && acc.getExpDate().isAfter(now());
        //요구 사항 추가(로직 자체를 감추고 외부에서는 이를 사용하게만 한다.)
        //즉, 해당 등급 유효성 검사는 등급 정보를 가진 계정이 책임을 지고 제공해야 한다.
        return this.membership == membership && expDate.isAfter(now()) && serviceDate.isBefore(now ().minusYears ( 5 ));
    }

    public Membership getMembership ( ) {
        return membership;
    }

    public LocalDate getExpDate ( ) {
        return expDate;
    }

    public LocalDate getServiceDate ( ) {
        return serviceDate;
    }
}
