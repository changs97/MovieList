
# Prography 7th Android Quest

> 프로그라피 Android 전형의 비중은 면접(70%), 과제(30%) 입니다. 과제의 완성도보다 면접이 더 중요합니다.

## 1. 개요

프로그라피는 짧은 기간동안 멋진 서비스를 뚝딱 만들어내기 때문에 안드로이드 클라이언트 개발 능력이 굉장히 중요합니다. 프로그라피 활동에 필요한 클라이언트 개발 능력 확인하기 위해 사전과제를 진행하고 있습니다. 사전과제에서는 간단한 기획과 요구사항에 맞춰 앱을 구현할 수 있는 지를 확인합니다.

더 궁금한 것이 있으시면 [해당 프로젝트 이슈](https://github.com/prography/prography-7th-android-quest/issues/new)로 남겨주세요! 늦어도 당일 이내에 답변을 남기도록 하겠습니다.

해당 레포지토리를 fork 하여 개발 진행해주시면 됩니다.

## 2. 과제

아래 설명을 읽고, 앱을 구현해주시기 바랍니다.

**해당 Repository를 fork하여 진행합니다.**

### a. 주제

ViewPager를 이용하여 Frament 전환이 가능한 앱 개발

### b. 필수 과제

#### 1. 기본 BottomNavigationView 화면 구현
* ViewPager2와 BottomNavigationView를 이용하여 화면 3개를 구현(각 화면은 `왼쪽 화면`, `가운데 화면`, `오른쪽 화면`으로 명칭)
* 제공되는 링크 ([https://ghibliapi.herokuapp.com/films](https://ghibliapi.herokuapp.com/films))를 사용하여, 영화목록 구현
* `왼쪽 화면`은 받아온 값을 점수(`rt_score`)를 기준으로 내림차순으로 정렬하여 영화 순위 리스트 구현
* `가운데 화면`은 받아온 값을 이름(`title` 혹은 `original_title_remanized` 사용) 알파벳 순으로 영화 목록 리스트를 구현
* `오른쪽 화면`은 선택과제로, 즐겨찾기 선택과제가 진행되지 않았다면 BottomNavigation의 Item 을 두개만 노출되도록 수정하여 구현
* 각 리스트의 아이템은 RecyclerView를 활용하여 제목, 감독, 설명, 점수, (이미지)가 노출되도록 설정하여야 함

### c.선택 과제

1. 즐겨찾기 기능
   * `왼쪽 화면`과 `가운데 화면`에 있는 리스트에 즐겨찾기 추가 기능을 구현
   * 즐겨찾기 된 영화는 리스트 우측 상단에 즐겨찾기 표시가 노출되어야 함. ( 즐겨찾기 상태 확인 및 즐겨찾기 설정 기능 구현 )
   * 즐겨찾기 된 영화는 `오른쪽 화면`의 리스트에 추가되어야 함.
      * Room을 활용하여 로컬 데이터베이스에 저장되어, 재시작 후에도 즐겨찾기에 남아있어야 함.
      * `오른쪽 화면`에서 즐겨찾기 해제 버튼 클릭시 리스트에서 사라지며, `왼쪽 화면`과 `오른쪽 화면`에서도 즐겨찾기가 해제되어야 함.
2. 상세페이지 기능
    * 아이템을 눌렀을 때 `상세 페이지`로 이동하도록 구현.
    * `상세 페이지`에는 제목, 이미지(URL이 아닌 이미지뷰), 설명, 각본, 감독, 출시일자, 러닝타임, 점수, 현재 즐겨찾기 여부의 정보가 노출되어야 함.
        * 상세페이지에 들어가는 데이터는 아이템의 ID를 가지고 링크 호출 방법을 참고하여 데이터를 호출.
      (예: [https://ghibliapi.herokuapp.com/films?id=2baf70d1-42bb-4437-b551-e5fed5a87abe](https://ghibliapi.herokuapp.com/films?id=2baf70d1-42bb-4437-b551-e5fed5a87abe) )
    * (선택) 즐겨찾기 기능이 상세페이지에도 적용되어야 하고, 현재 즐겨찾기 상태와, 즐겨찾기 설정 기능이 구현되어 있어야 함.

## 3. 제약 사항

- 사용언어는 반드시 Java 혹은 Kotlin으로 개발되어야 합니다.
- 네트워크 통신은 반드시 Retrofit2을 사용해야합니다.
- RecyclerView를 사용할 때 위아래 스크롤이 가능하도록 설정해주셔야합니다.

## 4. 우대 사항

- MVVM, MVP와 같은 디자인 패턴 적용
- RxJava 혹은 Kotlin Coroutine 사용
- Dependency Injection 적용
- Android Clean Architecture 적용
- ViewBinding과 DataBinding 적용
