const { createApp } = Vue;

const baseUrl = "http://localhost:8081/coin";
const mainContainer = {
    data() {
        return {
            coins: [],
            formCoin: {
                isNew: true,
                name: '',
                price: '',  // Corregido el nombre del atributo de precio
                quantity: '',
                title: 'Cadastrar nova transação',
                button: 'Cadastrar'
            }
        };
    },
    mounted() {
        this.showAllCoins();
    },

    methods: {
        showAllCoins() {
            axios
                .get(baseUrl)
                .then(response => {
                    this.coins = response.data;  // Simplificado para asignar directamente la respuesta al array coins
                })
                .catch(error => {
                    console.error("Error fetching coins:", error);
                });
        },
        saveCoin() {
            this.formCoin.name = this.formCoin.name.toUpperCase()
            this.formCoin.price =  this.formCoin.price.replace("R$", '')
                  .replace(',', '.').trim()

            if(this.formCoin.name == '' || this.formCoin.price == '' || this.formCoin.quantity == '') {
               toastr.error('Todos os campos do formulário são obrigatórios.', 'ERRO')
                return
            }

         const coin = {
               id: this.formCoin.id,
               name: this.formCoin.name,
               price: this.formCoin.price,
               quantity: this.formCoin.quantity
             }

         const self = this

         axios.put(baseUrl, coin)
               .then(function (response){
                toastr.success('Transação atualizada com sucesso!', 'Formulário')

               })
               .catch(function (error){
                   toastr.error('Não foi possível atualizar a transação.' + error, 'Formulário')
               })
               .then(function () {
                      self.showAllCoins()
                      self.showTransactions(self.formCoin.name)
                      self.cleanForm()
               })
        }
    }
};

createApp(mainContainer).mount('#app');
