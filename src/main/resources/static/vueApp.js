const { createApp } = Vue;

const mainContainer = {
    data() {
        return {
            coins: []
        };
    },
    mounted() {
        this.coins = [
            {
                name: 'teste1',
                quantity: 200
            },
            {
                name: 'teste2',
                quantity: 200
            }
        ];
    }
};

createApp(mainContainer).mount('#app');
