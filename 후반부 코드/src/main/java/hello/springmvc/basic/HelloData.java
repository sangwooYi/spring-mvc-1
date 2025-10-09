package hello.springmvc.basic;

import lombok.Data;

// 이거 쓰면 @Getter , @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 를 전부 다 세팅해주는 친구
// 참고 @EqualsAndHashCode 는 equals 메서드, hashCode 메서드를 필드 이용해서 자동으로 오버라이딩 (재정의) 해주는 친구
// 즉 @Data 를 쓰는순간 이친구 DTO 로 사용할수 있게 알아서 세팅해 준다.
@Data
public class HelloData {

    private String username;
    private int age;

}
