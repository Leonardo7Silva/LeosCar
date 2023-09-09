import model.PessoaFisica;
import model.PessoaJuridica;
import model.Veiculo;
import repository.PessoaFisicaRepository;
import repository.PessoaJuridicaRepository;
import repository.VeiculoRepository;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        PessoaJuridicaRepository ClientesJuridicos = new PessoaJuridicaRepository();
        PessoaJuridica pessoa1 = new PessoaJuridica("Leo", "1234");
        PessoaJuridica pessoa2 = new PessoaJuridica("Leo2", "5678");
        PessoaJuridica pessoa3 = new PessoaJuridica("Leo3", "7980");
        PessoaJuridica pessoa4 = new PessoaJuridica("Leo4", "8009");

        ClientesJuridicos.create(pessoa1);
        ClientesJuridicos.create(pessoa2);
        ClientesJuridicos.create(pessoa3);

        ClientesJuridicos.delete("5678");

        ClientesJuridicos.update("7980", pessoa4);

        System.out.println(ClientesJuridicos.findOne("1234"));

        VeiculoRepository veiculos = new VeiculoRepository();

        Veiculo veiculo1 = new Veiculo("Gol", "ABC1234", "SUV");
        Veiculo veiculo2 = new Veiculo("Uno", "ABD1235", "Pequeno");
        Veiculo veiculo3 = new Veiculo("Renegade", "ABE1230", "Medio");
        Veiculo veiculo4 = new Veiculo("Soul", "ABC2434", "SUV");

        veiculos.create(veiculo1);
        veiculos.create(veiculo1);
        veiculos.create(veiculo1);

        veiculos.delete("ABD1235");

        veiculos.update("ABE1230", veiculo4);

        System.out.println(veiculos.findAll());

    }
}