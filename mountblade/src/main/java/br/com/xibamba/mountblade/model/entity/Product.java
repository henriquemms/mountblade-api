package br.com.xibamba.mountblade.model.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 *
 *Entidade de produtos que podem ser negociados.
 *
 *Possui os campos:
 *- id: Identificador de registro, veja: @see {@link #id}
 *- name_en: Nome em inglês, veja {@link #name_en}
 *- name_br: Nome em português, veja {@link #name_br}
 *
 *Esta classe possui três notações:
 *- Entity: Indica para o framework Spring que a classe é uma entidade.
 *- Table: Indica para o framework Spring que deve tratar esta entidade 
 *como uma tabela no banco de dados e passa a propriedade "name" indicando
 *o nome da tabela no banco de dados
 *- Data: Gera os getters, settes e métodos necessários automaticamente. 
 *Para maiores informações ver documentação do lombok.
 *
 *   
 * @author Henrique Machado
 * @version 01.00.00
 * @since 01.00.00
 */
@Entity
@Table(name = "PRODUCT")
@Data
public class Product {

	/**
	 * Propriedade da entidade que identifica o produto
	 * 
	 * Possui duas notações:
	 * - Id: Especifica a chave primária da tabela
	 * - GeneratedValue: Define como é a geração dos valores para a chave primária da tabela. 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Propriedade da entidade que representa o nome em inglês do produto
	 * 
	 * Possui apenas a notação "Column" que define a propriedade como uma
	 * coluna da entidade. Esta notação possui três parâmetros:
	 * - name: nome do campo no banco de dados.
	 * - nullable: define se o campo pode ser nulo. 
	 * - length: define o tamanho máximo da string.
	 */
	@Column(name = "NAME_ENG", nullable = false, length = 255)
	private String name_en;
	
	/**
	 * Propriedade da entidade que representa o nome em português do produto
	 * 
	 * Possui apenas a notação "Column" que define a propriedade como uma
	 * coluna da entidade. Esta notação possui três parâmetros:
	 * - name: nome do campo no banco de dados.
	 * - nullable: define se o campo pode ser nulo. 
	 * - length: define o tamanho máximo da string.
	 */
	@Column(name = "NAME_BR", nullable = true, length = 255)
	private String name_br;
	
	/**
	 * Embarca a classe DataControl no Produto
	 */
	@Embedded
	private DataControl dataControl;
	
	
	/**
	 * Valida se o dataContrl está e caso esteja estancia um novo dataControl
	 * @return retorna o dataControl do produto 
	 */
	public DataControl getDataControl() {
		if(this.dataControl == null){
			this.dataControl = new DataControl();
		}
		return this.dataControl;
	}
}
