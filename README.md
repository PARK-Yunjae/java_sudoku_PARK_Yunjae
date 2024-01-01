# 자바 프로젝트 스도쿠 - 3일간의 삽질 일지

>### 1. 오프닝

	처음에는 이클립스 자바 콘솔 클리어 하는 걸 찾고 하려고했는데 결국 나오는건
	외부 라이브러리를 받아서 하는 방법이나 언어나 프로그램을 바꾸는 방법밖에 없었습니다
	그러다가 쓰레드에 알게되고 다른 방법인 Frame으로 새 창을 띄워서 하는 방법을 알게 되서 
	시간이 될지는 모르겠지만 배우는겸 해서 해보려고 합니다

>### 2. 구상 

	무엇을 할까 많이 고민을 했는데 게임을 좋아 하기도 해서 결국 게임으로 정했고
	그래픽이 들어가지 않는 게임중 뭐가 있을까 하다가 스도쿠도 좋아해서 스도쿠를 해보기로 했습니다
 
	필요한 화면
   
		메인화면 - 회원가입 로그인 종료 (화면에는 제목만 크게 간단하게 띄운다 배경은 아이보리나 흰색
		회원가입 - 아이디와 비밀번호 이름을 입력받는다(아이디 중복 검사 비밀번호 패턴 검사)
			- 메인 화면에서 회원 가입을 선택 하면 회원 가입 창으로 넘어감
			- 회원가입이 끝나면 다시 메인 화면으로 돌아옴

		로그인	- 메인 화면에서 로그인 창을 클릭하면 아이디와 비밀 번호를 입력하는 창이 뜨고 
			- 틀리면 메시지를 띄워주고 메인 화면으로 돌아감
  
	로그인 성공시에 로비 화면으로

		로비화면	- 중간에는 난이도 버튼 상 중 하 랭킹보기 도움말(게임 설명)
			- 상 중 하를 클릭 하면 게임 화면으로 넘어간다
			- 랭킹 보기를 클릭 하면 랭킹 보기 화면으로 넘어간다
			- 하단에는 로그아웃과 종료 버튼이 있다
			- 로그아웃을 누르면 메인화면 종료 버트을 누르면 게임이 저장되지 않고 종료된다

		게임화면	- 난이도별로 지워지는 숫자 개수와 실수 허용 개수가 다르다
			- 상단에는 난이도 실수(난이도별로 다름) 점수 시간(스레드로)
			- 중간에는 게임 화면
			- 하단에는 숫자 버튼과 지우기버튼
			- 실수 회수를 전부 채우면 게임 종료
			- 게임을 클리어 하면 난이도별 시간 순으로 랭킹에 올라간다
			- 하단에는 나가기와 종료 버튼이 있다
			- 나가기를 누르면 로비 화면으로 종료 버튼을 누르면 게임이 저장되지 않고 종료가 된다

		랭킹화면	- 랭킹은 순위 이름 점수 시간 순으로 보여주고 점수 기준으로 오름차순
			- 방향키로 쉬움 보통 어려움 랭킹 순위를 넘겨볼 수 있다
			- 나가기 버튼과 종료 버튼이 있다
			- 나가기를 누르면 로비화면으로 종료를 누르면 게임이 저장되지 않고 종료된다
               
>3. 설계 - 어떤 패키지와 어떤 클래스가 필요할까

	Package - _Main, Controller, dao, dto, MainMenu, LobbyMenu, GameMenu, RankMenu, Frame
	
	아직은 프레임을 다뤄본적이 없어서 생각은 여기까지

			Class
	_Main 		- Main

	Controller	- SudoKuController (여기서 화면 전환 컨트롤 - 쇼핑몰에서 했던 것처럼)
			- 여기서 화면 클래스가 가지고 있는 버튼이나 화면 정보를 맵으로 담을 수 있을까?

	dto		- Member (num, id, pw, name)
			- Rank   (num, id, score, time, level)

	dao		- MemberDAO
			- RankDAO
			- FileDAO
			- GameDAO

	MainMenu	- Join
			- Login
			- End

	LobbyMenu	- Low
			- Middle
			- High
			- Logout
			- Exit
			- End

	GameMenu	- one, two, three, four, five, six, seven, eight, nine
			- Eraser
			- Exit
		
	RankMenu	- Exit
			- End

	Frame		- MainFrame
			- LobbyFrame
			- GameFrame
			- RankFrame

>4. 구현 - 화면을 띄우는 것부터 막막하다

	일단 화면을 띄우고 버튼을 만들어보는 실습부터 해보았다.
	swing을 배워보려고 했으나 요즘  JavaFX가 대체되는 분위기라길래  JavaFX로 선회함.
	GUI를 하나도 몰라서 브레인 스토밍이 잘 안되는 관계로 먼저 학습을 해보기로 함

	- JavaFX 프로젝트 정상적으로 실행 시키는데 1시간이 걸릴줄은 몰랐음
	- https://heytech.tistory.com/176 링크를 남깁니다
	- swing을 더 편하게 쓰는 도구를 받는 방법 링크
	- https://www.youtube.com/watch?v=rDRTD4uoVB4 
	- 2:30 ~ 4:18
	- 이것도 설치하고 오류나서 실패
	- 재설치를 세번정도 하면서 해결이 되었는데 결국은 버전문제와
	- 검색해서 나오는 설치방법이 다들 달라서 중복 설치 되거나 해서 충돌이 생기는 문제
	- 2023-09 이클립스 jdk 17 버전에서 정상적으로 실행 됐던 방법은
	- https://wikidocs.net/208445
	- 이 사이트를 통해서 Eclipse Marketplace를 통한 windowbuilder검색 후(띄어쓰기 안됨)
	- WindowBuilder Current 를 설치하면 끝
	- 또 주의사항이 restart 문구가 뜨기전에는 이클립스를 끄지 말것 
	- 하단에 보면 설치중인 바가 보임

>5. 재구상

	JavaFx나 Swing을 좀 익힌 다음에서야 기존 구상은 수정이 필요 하다는걸 깨닫고 구상 단계부터 다시 함
	위에선 그래픽이 들어가지 않는다고 했는데 GUI에선 어림도 없는 일이었고 
	배경이나 버튼도 이미지가 필요함을 절실하게 느낌
	버튼에 이미지를 써야 겠다는 점을 제외하곤 구상에선 달라진게 없을것 같다
	랭킹뿐만 아니라 다른 메뉴에서도 방향키로 버튼을 옴겨다니는것도 나쁘지 않아 보임
	랭킹은 난이도 별로 10위 까지만 보여주고 10위 밖으로 밀려나면 가지고 있다가 탈퇴 하거나 했을때 다시 올라온다

>6.재설계 
	
	src에는 소스파일이 저장되서 img라는 새로운 폴더를 만들어서 이미지를 저장한다

	Package - _Main, Controller, dao, dto, MainMenu, LobbyMenu, GameMenu, RankMenu, Frame
	
	아직은 프레임을 다뤄본적이 없어서 생각은 여기까지

			Class
	_Main 		- Main	// 실행

	Controller	- SudoKuController // 패널 컨트롤 - 화면 숨기고, 화면 보이고

	dto		- Member (num, id, pw, name)	  
			- Rank   (id, score, time, level) // 저장만 되고 탈퇴시 삭제되니 변수가 크게 필요하지 않을듯

	dao		- MemberDAO	// 회원 가입, 수정, 탈퇴
			- RankDAO	// 랭킹 계산해서 출력해주는 용도만 할듯
			- FileDAO	// 랭킹 맴버 파일 저장(x버튼 말고 종료 버튼 누를시 자동 저장), 로드(실행시)
			- GameDAO	// 게임 규칙을 지켜서 맵을 만든 후 난이도 별로 지워줘서 출력해주는 맵 구현
					// 실수 스코어 시간 갱신, 정답시 체크 
	
	panel		- GamePanel	// 81개의 텍스트, 1~9숫자 버튼 나가기, 상단에는 난이도 스코어 실수 시간(쓰레드?)
			- JoinPanel	// 회원가입 id pw name 텍스트, 회원가입 버튼, id 확인 버튼
			- LobbyPanel	// 상단에 이름 텍스트, 중앙에 상 중 하 난이도 버튼, 좌하단 랭크, 우하단 나가기
			- MainPanel	// 게임 실행 시 처음 나타나는 패널 id pw입력하는 텍스트 라벨과, 회원가입 로그인 버튼
					// 나가기 버튼도 만들자
			- RankPanel	// 난이도 별로 10위까지 랭크 표시(스코어 순)

>7.재구현 : 자고나서

	GUI 라고 해서 결과를 확인하는건 쉽지 않아 보임 
	어찌 저찌 화면 구현은 했는데 스도쿠 생성 로직이 생각보다 까다롭다
	1. 같은 행 또는 열에 같은 숫자가 두번 이상 나오면 안된다
	2. 스도쿠 배열은 9등분(3*3 크기의 부분 배열 9개)했을때  같은 영역 안에 숫자가 겹치면 안된다

	규칙 하나하나는 괜찮은데 같이 적용 시키려니 까다롭다
	생각보다 노다가로 해결하고

	쉬움 :40  보통 :35  어려움 : 30  - 이것보다 1~2개가 적은게 일반적인 난이도로 보임
	라벨로 어떻게든 클릭 이벤트 해보려고 했으나 무리 그냥 버튼으로 선회
	한나절 동안 검색하고 수정하면서 방법을 찾아냄 다시 라벨로 전환
	배우고 했으면 모르겠는데 하면서 배운다는게 결코 쉽지 않음을 다시 한번 느끼고 있음

	JTable을 선택적으로 띄운다고 또 이상한테스트 하다가 늦어짐

	모르는것들은 계속 찾아가면서 하느라 많이 늦어졌는데 기능 구현은 완료해서 여기에서 마무리 하는것으로
	더 잘 할 수 있을것 같다는 아쉬움이 남는 프로젝트 였던것 같습니다.
	
	
