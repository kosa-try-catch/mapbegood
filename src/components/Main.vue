<template>
    <div>
        <Menubar />
        <Section />
        Main입니다
    </div>
</template>
<script>
import Menubar from './Menubar.vue';
import Section from './Section.vue';
export default {
    name: "Main",
    components: {Menubar, Section}
}
</script>
<style scoped>
div.menubar{
    display: inline-block;
}
div.section{
    display: inline-block;
    left: 100px;
}
</style>