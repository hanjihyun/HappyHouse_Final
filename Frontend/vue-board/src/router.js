import Vue from "vue";
import Router from "vue-router";
import header from "./components/Header.vue";
import QnAList from "./components/QnAList.vue";
import QnADetail from "./components/QnADetail.vue";
import QnASearch from "./components/QnASearch.vue";
import QnAUpdate from "./components/QnAUpdate.vue";
import QnAInsert from "./components/QnAInsert.vue";
import QnASearchByWriter from "./components/QnASearchByWriter.vue";
Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "qna",
      alias: "/qna",
      component: QnAList
    },
    {
      path: '/qnaDetail/:qnaNo',
      name: 'qnaDetail',
      component: QnADetail,
      props: true,
    },
    {
      path: "/qnasearch",
      name: "qnasearch",
      component: QnASearch
    },
    {
      path: "/qnaUpdate/:qnaNo",
      name: "qnaUpdate",
      component: QnAUpdate,
      props: true,
    },
    {
      path: "/qnainsert",
      name: "qnainsert",
      component: QnAInsert
    },
    {
      path: "/searchByWriter",
      name: "searchByWriter",
      component: QnASearchByWriter
    },
    {
      path: "/header",
      name: "header",
      component: header
    }
  ]
});