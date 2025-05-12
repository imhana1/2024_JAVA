프로그램 골격, MVC 패턴을 활용한 연락처 관리 프로그램(주소록)
데이터 : 이름, 연락처, 주소, 생일
메뉴 구성
1. 연락처 입력
2. 연락처 전체 출력
3. 연락처 검색(개별 출력)
    3.1 이름
    3.2 연락처
    3.3 생일
4. 연락처 수정
5. 연락처 삭제
0. 종료

url - www.somedomain.com
    회사 - com, co.kr
    공공 - org, or.kr
    교육 - ac, ac.kr
    통신 - net,
    개인 - pe

프로젝트의 package 구성은 url을 역순으로 작성.

MainClass.main() ->
Controller.run() -> View(입력) -> Controller
-> Service -> Dao -> Service -> Controller -> View(출력)

코딩의 재미.....?
    error가 나서 막 안되다가도 문제가 해결되서 원하는대로 실행될 때 쾌감...? - 선생님 말
