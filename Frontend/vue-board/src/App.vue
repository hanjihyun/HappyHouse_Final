<template>
<div id="app">
  <Header>
  </Header>

<div class='search_box'>
 <nav>
        <router-link class="btn btn-dark" to="/">모든 목록</router-link> |
        <router-link class="btn btn-dark" to="/qnasearch">제목으로 검색</router-link> |
        <router-link class="btn btn-dark" to="/searchByWriter">작성자로 검색</router-link> |
 </nav>
</div>
        <router-view/>
        <Footer>
  </Footer>
</div>
</template>


<script>
import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';
export default {
  name: "app",
  components:{
    Header,
    Footer
  }
};
</script>

<style>

</style>
