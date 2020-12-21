<template>
<div>
  <div class='headtitle'><h2>Q&A 상세페이지</h2></div>
<table class='list_table'>
 <col width="15%" />
  <col width="40%" />
  <col width="20%" />
  <col width="25%" />
  <tr>
   <th>No</th>
  <th>제목</th>
  <th>작성자</th>
  <th>날짜</th>
</tr>
 <tr>
  <td v-html="qna.qnaNo"></td>
  <td v-html="qna.title"></td>
  <td v-html="qna.writer"></td>
  <td v-html="qna.date"></td>  
</tr>

</table>
<table class='list_table'>
  <col width="100%" />
<tr>
   <th>내용</th>  
<tr>
<div class="form-group" align="center">
    <td v-html="qna.content"></td>
</div>
</tr>
</table>
<br>
    <div align="center">
        <b-button variant="dark" @click="movePage">목록</b-button>
        <b-button variant="dark" @click="updatePage(qna.qnaNo)">수정</b-button>
        <b-button variant="dark" @click="delete_qna(qna.qnaNo)">삭제</b-button>
    </div>
    <br>
</div>
</template>

<script>
import http from "../http-common";
import Vue from 'vue'
import { BootstrapVue, BootstrapVueIcons } from 'bootstrap-vue'

import axios from "axios"; 
Vue.use(BootstrapVue)
Vue.use(BootstrapVueIcons)

export default {
  name: "qnaDetail",
  props: ['qnaNo'],
  data () {
    return {
      info: [],
      qna:{}
    }
  },
  mounted () {
    
    http
    .get('/qnaDetail/'+this.qnaNo)
    .then(response => (this.qna = response.data))
    .catch(() => {
      this.errored = true
    })
    .finally(() => this.loading = false);

  },
  methods:{
    movePage() {
          this.$router.push('/');
        },
    delete_qna(){
    axios.post('http://localhost:8001/happyHouse/qna/qnaDelete/'+ this.qnaNo)
    .then(({ data }) => {
      let msg = '삭제 처리시 문제가 발생했습니다.';
      if (data === 'success') {
        msg = '삭제가 완료되었습니다.';
      }
      alert(msg);
       this.movePage();
    });
    },
    updatePage(qnaNo){
     this.$router.push('/qnaUpdate/' + qnaNo);
    }
  }

}
</script>

<style>
.searchform {
  max-width: 300px;
  margin: auto;
}
.search-result {
  margin-top: 20px;
  text-align: left;
}
</style>