#Coverage: 61.9%
*Previously coverage was 69.2% as seen in presentation, but due to debugging java application and sql, coverage decreased.
*With all tests coverage is 61.9% when DAO tests aren’t disabled

# Project Title IMS-Starter – Elina McGlinchey 

The purpose of this project is to manage inventories with customers, items and orders, hence the Inventory Management System (IMS). I was provided with a skeleton for the project and a brief to get started on the tasks. This project was a huge opportunity for learning and I have expanded my understanding and debugging skills in preparation for future projects. We had to create a project that would be able to create, update, read all and delete customers, items and orders. The skeleton only provided incomplete customer classes, item and order had to be done independently and follow format.

## Getting Started

These instructions will get you a copy of the Week 5 project and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

To begin with –
You will need to have –
1. Eclipse 
2. Java
3. MySQL
4. GitBash
5. Maven

You will need to create an account with –

```

1. Jira https://www.atlassian.com/software/jira?&aceid=&adposition=&adgroup=95003673569&campaign=9124878942&creative=542638229999&device=c&keyword=jira%20software&matchtype=e&network=g&placement=&ds_kids=p51241609041&ds_e=GOOGLE&ds_eid=700000001558501&ds_e1=GOOGLE&gclid=CjwKCAjw7cGUBhA9EiwArBAvok5aoLzE-r9BcUUwdQJ69odDFke6_3svmX7560YILj5Cb1FGqWgPoxoC_5AQAvD_BwE&gclsrc=aw.ds
2. Github https://github.com/join

```

*TIP – try and use same email address for all accounts to avoid conflict

```

- Java 8 (https://www.oracle.com/java/technologies/downloads/#java8)
Guide on how to install Java provided by Oracle (https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)

- MySQL 8 (https://dev.mysql.com/downloads/windows/installer/8.0.html)
Guide from MySQL site (https://dev.mysql.com/doc/refman/8.0/en/installing.html)*
* Note that we need MySQL Server and MySQL Workbench for hosting a database and running queries

- Eclipse IDE (https://www.eclipse.org/downloads/)
Guide on installation from the Eclipse website (https://www.eclipse.org/downloads/packages/installer)

- Maven (https://maven.apache.org/download.cgi)
Guide on installation for Maven provided on their website (https://maven.apache.org/install.html)

```

*Recommended to download Workbench for easier debugging of MYSQL*

If you choose to use this project, fork this repository. Although it’s not fully completed, a huge chunk of the work is complete – I plan to keep re-editing this in the future in order to improve all tests (coverage and Java Application).

### How to use the IMS Application -

Example used – Customers (repeat same steps for Items and Order)

```
CREATE
```
As application is now up and running, once you have typed in ‘Customers’ to the console, we can type ‘CREATE’. Create will allow you to create the Customer’s name, surname, username and password. Once all 4 variables in the new method are chosen, they are inputted into the database.

```
UPDATE
```
Updating works very similarly to the create function, following steps the same way in which you did before(in the console). 

```
DELETE
```
Deleting the method works similarly to the other two functions and it follows the same instruction pattern in the console as before, but delete one of the customers you have created for good practice.

```
READ

```
Once you have created your customer(s), the ‘READ’ function in the console will display all the customers you have created, updated, or deleted in the database.

```
RETURN
```

To exit Customer, type ‘RETURN’ into the console, this will return you to the homepage so you are able to select either Customers, Items or Orders again.

## Running the tests

### Unit Tests 

The connection between Java and MySQL.
```
public void testCreate() {
@Test
	public void testCreate() {
		final Item created = new Item(3L, 3.85, "bottle");
		assertEquals(created, DAO.create(created));
	}
```

### Integration Tests 

For integration testing, Mockito was used to mock the methods. The purpose of Mockito is to test how effective controllers are working for each object.

```
@Mock
	private Utils utils;

	@Mock
	private ItemDAO dao;

	@InjectMocks
	private ItemController controller;

	@Test
	public void testCreate() {
		final Long ITEM_ID = 1L;
		final Double ITEM_COST = 0.65;
		final String ITEM_NAME = "pencil";
		final Item created = new Item(ITEM_ID, ITEM_COST, ITEM_NAME);```

## Deployment

- Take time doing tests, complete Customer, CustomerDAO, CustomerController, CustomerConrollerTest before starting Item or Order.
- Remember to update CrudController and input Item and Order.
- Be very mindful of git pushes, ensure that your basic git knowledge is up to scratch when creating branches or pushes.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Elina McGlinchey** - *Forked Project*
[elinamcglinchey] (https://github.com/elinamcglinchey)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
