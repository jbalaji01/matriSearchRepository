import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { ICrudGetAllAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './field-attribute.reducer';
import { IFieldAttribute } from 'app/shared/model/field-attribute.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IFieldAttributeProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const FieldAttribute = (props: IFieldAttributeProps) => {
  useEffect(() => {
    props.getEntities();
  }, []);

  const { fieldAttributeList, match, loading } = props;
  return (
    <div>
      <h2 id="field-attribute-heading">
        Field Attributes
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp; Create new Field Attribute
        </Link>
      </h2>
      <div className="table-responsive">
        {fieldAttributeList && fieldAttributeList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>ID</th>
                <th>Attribute Name</th>
                <th>Attribute Value</th>
                <th>Field</th>
                <th />
              </tr>
            </thead>
            <tbody>
              {fieldAttributeList.map((fieldAttribute, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${fieldAttribute.id}`} color="link" size="sm">
                      {fieldAttribute.id}
                    </Button>
                  </td>
                  <td>{fieldAttribute.attributeName}</td>
                  <td>{fieldAttribute.attributeValue}</td>
                  <td>
                    {fieldAttribute.fieldFieldName ? (
                      <Link to={`field/${fieldAttribute.fieldId}`}>{fieldAttribute.fieldFieldName}</Link>
                    ) : (
                      ''
                    )}
                  </td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${fieldAttribute.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" /> <span className="d-none d-md-inline">View</span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${fieldAttribute.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${fieldAttribute.id}/delete`} color="danger" size="sm">
                        <FontAwesomeIcon icon="trash" /> <span className="d-none d-md-inline">Delete</span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && <div className="alert alert-warning">No Field Attributes found</div>
        )}
      </div>
    </div>
  );
};

const mapStateToProps = ({ fieldAttribute }: IRootState) => ({
  fieldAttributeList: fieldAttribute.entities,
  loading: fieldAttribute.loading,
});

const mapDispatchToProps = {
  getEntities,
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(FieldAttribute);
