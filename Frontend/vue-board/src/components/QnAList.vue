<template>
<div>
  <div class='headtitle'><h2>Q&A</h2></div>
<div>
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
</div>
</template>

<script>
import http from "../http-common";
export default {
  name: "qna-list",
  data(){
    return {
      upHere : false,
      info: [],
      loading: true,
      errored: false 
    }
  },
  methods:{
    retrieveQnAs() {
      http
        .get('/findAllQnAs')
          .then(response => (this.info = response.data))
          .catch(()=> {
            this.errored = true
          })
          .finally(() => this.loading = false);
    },
    refreshList() {
      this.retrieveQnAs();
    },
    show_detail:function(qnaNo){
          alert(qnaNo+"번 글 상세보기");
          this.$router.push('/qnaDetail/' + qnaNo);
    } ,
    insertQnA(){
      this.$router.push('/qnainsert');
    }
  },
  filters: {
        salarydecimal (value) {
        var a=parseInt(value);
        return a.toFixed(2);
      }
    }, 
    mounted () {
        this.retrieveQnAs();
    }
};
</script>

<style>

</style>
