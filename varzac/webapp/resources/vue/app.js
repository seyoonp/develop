// 전역 컴포넌트 등록 header
Vue.component('my-global-header', {
	template : '<div>헤더입니다.</div>'
});

//전역 컴포넌트 등록 footer
Vue.component('my-global-footer', {
	template : '<div>푸터입니다.</div>'
});
new Vue({
	el: '#app',
	data : {
		message : "컨텐츠입니다."
	}
});