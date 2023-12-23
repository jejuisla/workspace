const serviceKey = "xjr91ulq/m7d/LwUWEkDAKl7Bo5OdLa7q9Db1PVhqH3/LFLxcFamNlIVQIf1QXAhFda32vIxn0abtP+dC+4PMQ==";

const getAirPollution = (sidoName) => {
  const requestUrl = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";

  // 쿼리 스트링 생성 (URLSearchParams.toString())

  const searchParams = new URLSearchParams();

  searchParams.append("returnType", "JSON");

  searchParams.append("sidoName", "서울");
  searchParams.append("sidoName", "부산");
  searchParams.append("sidoName", "대전");

  fetch(`${requestUrl}?${searchParams.toString()}`)
    .then((resp) => resp.json())

    .then((result) => {
      console.log(result);
    })

    .catch((e) => console.log(e));
};
