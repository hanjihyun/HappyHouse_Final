<template>
  <div>
  <div class='headtitle'><h2>Q&A 수정</h2></div>
    <div class="form-group">
      <input
        type="hidden"
        class="form-control"
        id="no"
        ref="no"
        v-model="qna.qnaNo"
      />
      <label for="writer">작성자</label>
      <input
        type="text"
        class="form-control"
        id="writer"
        ref="writer"
        v-model="qna.writer"
        disabled
      />
    </div>
    <div class="form-group">
      <label for="title">제목</label>
      <input
        type="text"
        class="form-control"
        id="title"
        ref="title"
        v-model="qna.title"
      />
    </div>
    <div class="form-group">
      <label for="content">내용</label>
      <textarea
        type="text"
        class="form-control"
        id="contnet"
        ref="content"
        v-model="qna.content"
      ></textarea>
    </div>
    <br />
    <br />
    <div align="center">
      <b-button variant="dark" @click="movePage">목록</b-button>
      <b-button variant="dark" @click="update_qna()">수정 완료</b-button>
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
  name: "qnaUpdate",
  props: ['qnaNo'],
  data () {
    return {
      qna:{},
      no:"",
      writer:"",
      title:"",
       content:"",
     date:""
    }
  },
  mounted () {

    http
    .get('/qnaUpdate/'+this.qnaNo)
    .then((response) => this.qna = response.data)
    .catch(() => {
      this.errored = true
    })
    .finally(() => this.loading = false);
  
  },
  methods:{
    movePage() {
          this.$router.push('/');
        },
   update_qna() {
      axios.post('http://localhost:8001/happyHouse/qna/qnaUpdate',this.qna)
        .then(({ data }) => {
          let msg = '수정 처리시 문제가 발생했습니다.';
          if (data === 'success') {
            msg = '수정이 완료되었습니다.';
          }
          alert(msg);
          this.movePage();
        });
    },

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
