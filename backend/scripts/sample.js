import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
    //vus: 10,    //가상 사용자 수          10명의 사용자가 30초 동안 url로 GET요청 발생시키는 테스트
    //duration: '30s' //총 테스트 시간

    discardResponseBodies: true,    //모든 https응답 본문 무시
    scenarios: {
        contacts : {
            executor: 'per-vu-iterations',  //각 사용자에 대해 지정한 수 만큼 반복 수행 하도록함
            vus: 10,    //가상 사용자
            iterations: 20,     //각 가상 사용자가 반복 수행할 횟수
            maxDuration: '30s'      //시나리오의 최대 실행 시간
        }
    }

};

export default function(){
    http.get('https://test.k6.io');
    sleep(1);
}