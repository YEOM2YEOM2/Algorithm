/*
https://sjaqjnjs22.tistory.com/247
WITH절 :  가상테이블 생성
ex) WITH 가상테이블명 AS (
        SELECT 쿼리
        UNION ALL -- 뭐 붙이거나 할 경우 추가
        SELECT 쿼리
    )

& 연산자 : 비트 연산자, 대응되는 비트가 모두 1이면 1을 반환함(AND 연산)
*/

WITH FRONTEND AS (
    SELECT CODE FROM SKILLCODES
    WHERE CATEGORY = "Front End"
)

SELECT DISTINCT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME FROM DEVELOPERS AS D
JOIN FRONTEND AS F
ON D.SKILL_CODE & F.CODE
ORDER BY D.ID;