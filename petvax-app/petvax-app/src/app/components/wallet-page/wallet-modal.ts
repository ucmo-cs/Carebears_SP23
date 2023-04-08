/* Modal used to map wallets and its respective vaccines. Variables should match db.json file. 
 * Variable and types will need to be updated as described in the backend when connecting to backend. 
*/

export interface Wallets {
    id: number;
    name: string;
    purpose: string;
    vaccines: Vaccine[];
}

export interface Vaccine {
  id: number;
  name: string;
  provider: string;
  date: Date;
}