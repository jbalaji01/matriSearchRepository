import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { ICrudGetAllAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './query.reducer';
import { IQuery } from 'app/shared/model/query.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IQueryProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const Query = (props: IQueryProps) => {
  useEffect(() => {
    props.getEntities();
  }, []);

  const { queryList, match, loading } = props;
  return (
    <div>
      <h2 id="query-heading">
        Queries
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp; Create new Query
        </Link>
      </h2>
      <div className="table-responsive">
        {queryList && queryList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>ID</th>
                <th>Query Name</th>
                <th>Peck Order</th>
                <th>Profile</th>
                <th />
              </tr>
            </thead>
            <tbody>
              {queryList.map((query, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${query.id}`} color="link" size="sm">
                      {query.id}
                    </Button>
                  </td>
                  <td>{query.queryName}</td>
                  <td>{query.peckOrder}</td>
                  <td>{query.profileName ? <Link to={`profile/${query.profileId}`}>{query.profileName}</Link> : ''}</td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${query.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" /> <span className="d-none d-md-inline">View</span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${query.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${query.id}/delete`} color="danger" size="sm">
                        <FontAwesomeIcon icon="trash" /> <span className="d-none d-md-inline">Delete</span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && <div className="alert alert-warning">No Queries found</div>
        )}
      </div>
    </div>
  );
};

const mapStateToProps = ({ query }: IRootState) => ({
  queryList: query.entities,
  loading: query.loading,
});

const mapDispatchToProps = {
  getEntities,
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(Query);
