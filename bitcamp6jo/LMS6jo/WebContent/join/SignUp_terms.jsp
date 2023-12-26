<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet" type="text/css" href="./../css/SignUp.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        function check1() {
            var ch1 = document.getElementById("chk1");
            var ch2 = document.getElementById("chk2");
            var ch3 = document.getElementById("chk3");
            if (ch1.checked == true) {
                document.getElementById("chk1").value = 'Y';
            } else {
                document.getElementById("chk1").value = 'N';
                btn.disabled = true;
                return false;
            }
            if (ch2.checked == true) {
                document.getElementById("chk2").value = 'Y';
            } else {
                document.getElementById("chk2").value = 'N';
                btn.disabled = true;
                return false;
            }
            if (ch3.checked == true) {
                document.getElementById("chk3").value = 'Y';
            } else {
                document.getElementById("chk3").value = 'N';
                btn.disabled = true;
                return false;
            }
            if ((ch1.value && ch2.value && ch3.value) == 'Y') {
                btn.disabled = false;
            }
        }
        function move(url){
        	location.href=url;
        }
    </script>
</head>
<body>
<%@ include file="./../common/header.jspf" %>
		<div id="total">
    <h1 class="title">회원가입</h1><br><br>    
    <h2 class="subtitle">이용약관</h2>
    <div>
        <textarea class="ta">  제 1 장 총칙
제 1 조 (목적)
이 약관은 주식회사비트컴퓨터 부설 비트교육센터(이하 센터라 합니다)가 제공하는 IT교육사업 관련 서비스(이하 서비스라 합니다)를 이용함에 있어 이용조건 및 절차와 기타 필요한 사항을 규정하는 것을 목적으로 합니다.
제 2 조 (약관의 효력 및 변경)
약관은 사이트를 이용하고자 하는 모든 회원에 대하여 그 효력을 발생합니다.
회사는 본 약관의 내용과 회사의 상호, 소재지, 대표자의 성명, 사업자등록번호, 연락처(전화, 팩스, e-mail주소 등) 등을 이용자가 알 수 있도록 사이트의 초기 서비스화면에 게시합니다.
회사는 약관의규제에관한법률, 전자거래기본법, 전자서명법, 정보통신망이용촉진및정보보호등에관한법률, 전자상거래등에서의소비자보호에관한법률, 방문판매등에관한법률, 소비자보호법, 개인정보보호법 등 관련법을 위배하지 않는 범위에서 본 약관을 변경할 수 있습니다.
회사는 필요하다고 인정되는 경우 본 약관을 변경할 수 있으며, 약관이 변경되는 경우에는 변경된 약관의 적용일자 및 사유를 명시한 변경된 약관과 현행 약관을 함께 지체없이 제8조에서 정한 방법으로 회원에게 공시합니다. 약관 변경 이전의 기존 회원이 제4항의 공시 기간 동안 변경된 약관에 동의하는 경우 변경약관의 조항이 적용됩니다.
회원이 변경된 약관에 동의하지 않으면 사이트를 탈퇴하여 서비스의 이용 계약을 해지할 수 있습니다. 단, 이의가 있음에도 제4항에 정한 바에 따른 회사의 고지가 있은 후 30일 이내에 이용 계약을 해지하지 않은 회원은 변경된 약관에 동의한 것으로 간주합니다.
제 3 조 (약관 외 준칙)
이 약관에 명시되지 않은 사항이 관계 법령에 규정되어 있을 경우에는 그 규정에 따릅니다.
제 4 조 (용어의 정의)
이 약관에서 사용하는 용어의 정의는 다음과 같습니다.
회원 : 사이트에 접속하여 본 약관에 동의하고 개인정보를 제공하여 회원등록을 하고 회사가 제공하는 서비스를 이용하는 자
아이디 : 회원의 식별과 회원의 서비스 이용을 위하여 회원이 선정하고 회사가 승인하는 문자나 숫자 혹은 그 조합을 말합니다(이하 "ID"라 합니다).
비밀번호 : 회원이 부여받은 ID와 일치된 회원임을 확인하고, 회원 자신의 비밀을 보호하기 위하여 회원이 정한 문자와 숫자의 조합을 말합니다.
해지 : 회사 또는 회원이 서비스 사용 후 이용계약을 해약하는 것을 말합니다.
    </textarea>
    </div>
    <div>
        <input type="checkbox" name="chk1" id="chk1" onclick="check1()" /><label>위의 "이용약관"에 동의합니다.</label>
    </div><br>
    <h2 class="subtitle">개인정보처리방침</h2>
    <div>
        <textarea class="ta">'㈜비트컴퓨터'(이하 “회사” 또는 “비트교육센터”라 함)는 정보통신망 이용촉진 및 정보보호 등에 관한 법률, 개인정보보호법, 통신비밀보호법, 전기통신사업법, 등 정보통신서비스제공자가 준수하여야 할 관련 법령상의 개인정보보호 규정을 준수하며, 관련 법령에 의거한 개인정보처리방침을 정하여 이용자 권익 보호에 최선을 다하고 있습니다.
1. 수집하는 개인정보의 항목 및 수집방법
(1) 수집항목
회사는 회원가입, 서비스 신청, 변경 및 해지, A/S 서비스, 상담, 교육과정 소개, 이벤트 안내 및 이용자관리 등을 위하여 아래와 같은 개인정보를 수집하고 있습니다.
교육관련정보
- 필수 : 성명, ID, 비밀번호, i-pin, 전화번호, 휴대전화번호, e-mail, 메일수신여부, 직업, 학력사항
고용보험환급관련 정보 (고용보험 환급과정 수강신청 시 별도 수집)
- 주민등록번호
보험가입관련 정보 (보험가입 필수과정 수강신청 시 별도 수집)
- 주민등록번호
이용자는 동의를 거부할 권리가 있습니다. 동의를 거부할 경우 상기의 정보수집을 필요로 하는 서비스를 제공받으실 수 없습니다.
또한, 서비스 이용과정이나 사업처리 과정에서 아래와 같은 정보들이 생성되어 수집될 수 있습니다.
- 서비스 이용기록, 결제수단에 대한 기록여부(계좌, 신용카드), 결제기록
(2) 수집방법
회사는 다음과 같은 방법으로 개인정보를 수집합니다.
- 회사는 제공하는 서비스에 대하여 고객의 원활한 사용지원을 위해 홈페이지(회원가입), 서면양식, 고객에 대한 상담, 서비스 신청, 배송지 정보 수정/입력, 이벤트/설문 참여 등의 방법으로 고객의 개인정보를 수집하고 있습니다
    </textarea>
    </div>
    <div>
        <input type="checkbox" name="chk1" id="chk2" onclick="check1()" /><label>위의 "개인정보처리방침"에 동의합니다.</label>
    </div><br>
    <h2 class="subtitle">제3자 제공에 대한 동의</h2>
    <div>
        <textarea class="ta"> 회사는 이용자의 개인정보를 원칙적으로 외부에 제공하지 않습니다.
- 이용자들이 사전에 동의한 경우
- 법령의 규정에 의거하거나, 수사 목적으로 법령에 정해진 절차와 방법에 따라 수사기관의 요구가 있는 경우
- 학습자가 수강하는 과정에 따른 제3자 제공내역
구분	제공받는 자	제공받는 자의 이용목적	제공받는 개인정보	보유 및 이용기간
내일배움카드제 과정	고용노동부	내일배움카드제 과정 신청	성명, 주민등록번호	5년
국가기간전략산업직종훈련과정	고용노동부	국가기간전략산업직종훈련과정 위탁계약 체결	성명, 주민등록번호, 연락처, 이메일, 주소, 계좌번호	5년
고용보험환급과정	한국산업인력공단	고용보험환급과정 환급관련 업무	성명, 주민등록번호, 연락처	5년
청년취업아카데미교육	청년취업아카데미교육 수강/수료/교육지원 대상확인 및 관리	성명, 주민등록번호, 수료번호, 연락처, 취업일자, 취업업체명,사업장관리번호	3년
청년취업아카데미교육	동부화재	청년취업아카데미교육 재해보험가입	성명, 주민등록번호	2년
    </textarea>
    </div>
    <div>
        <input type="checkbox" name="chk1" id="chk3" onclick="check1()" /><label>위의 약관에 동의합니다.</label>
    </div><br><br>
    <div>
        <input type="button" value="다 &nbsp&nbsp음" id="btn" disabled="disabled" onclick="move('SignUp_Info.jsp')"/>
    </div>
    </div>
<%@ include file="./../common/footer.jspf" %>   
</body>
</html>