export class Heritages {
  heritageId: number;
  authority: string;
  dateofconstructionfrom: Date;
  dateofconstructionto: Date;
  city: string;
  postcode: string;
  streetAddress: string;
  streetNumber: string;
  suburb: string;
  architecturalstyleArchstyleId: ArchitecturalStyle;
  heritagegroupGroupId: HeritageGroup;
}
export class ArchitecturalStyle {
  archstyleId: number;
  periodfromto: string;
  periodname: string;
}

export class HeritageGroup {
  groupId: number;
  groupcategory: string;
  groupsubcategory: string;
}
