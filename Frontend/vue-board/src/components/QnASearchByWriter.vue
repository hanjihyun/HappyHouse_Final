<template>
<div>
    <div class='headtitle'><h2>Q&A 검색</h2></div>
<div class='search_box'>
작성자로 검색 : <input type="text" name='name' v-model="writer" @keyup='searchname' v-cloak/>
</div>
 <div align="right" style="margin-right:20px;">
  <button class="btn btn-dark" @click="insertQnA">Q&A등록</button>
</div>
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
<tr v-for="qna in info" class = "nicecolor" :key="qna.qnaNo">
  <td v-html="qna.qnaNo"  @click="show_detail(qna.qnaNo)"></td>
  <td v-html="qna.title"  @click="show_detail(qna.qnaNo)"></td>
  <td v-html="qna.writer"></td>
  <td v-html="qna.date"></td>

 </tr>
</table>

</div>
</template>

<script>
import http from "../http-common";

export default {
  name: "search-customer",
  data () {
        return {
         // info: [],
          loading: true,
          errored: false ,
          writer:'',
          info:[]
        }
      },
  methods: {
    searchname(e) {
      if(e.which == 13){ //enter
        http
        .get('/findQnaByWriter/'+this.writer)
        .then(response => (this.info = response.data))
        .catch(() => {
          this.errored = true
        })
        .finally(() => this.loading = false);   
      }
    },
    insertQnA(){
      this.$router.push('/qnainsert');
    }
  }
};
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