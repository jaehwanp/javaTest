select A.userno,B.name,A.state,(select to_char(A.attdate,'MM-DD') from dual) as attdate from attend A,users B,subject C  where A.userno=B.userno and C.classno=B.classno and A.attdate between to_date('0701','MM-DD') and to_date('0731','MM-DD');
select A.userno,B.name,A.state,(select to_char(A.attdate,'MM-DD') from dual) as attdate from attend A,users B,subject C  where A.userno=B.userno and C.classno=B.classno and 

SELECT EXTRACT(MONTH FROM SYSDATE) FROM DUAL;

select a.subno as num, a.subnm as subname, a.limitno as limitNum, a.limitEnd as limitEnd, a.subcontent as content, b.name 
from subject a, admins b where a.adno=b.adno and b.adno=1